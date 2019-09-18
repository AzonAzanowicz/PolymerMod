package azon.polymer.tiles;


import azon.polymer.blocks.GeneratorSolidFuel;
import azon.polymer.containers.ContainerGeneratorSolidFuel;
import azon.polymer.init.ModBlocks;
import azon.polymer.init.ModTileEntityTypes;
import azon.polymer.temp.CustomEnergyStorage;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TileGeneratorSolidFuel extends LockableTileEntity implements ITickableTileEntity, INamedContainerProvider, ISidedInventory {

    private int burnTime;
    private int recipesUsed;
    private boolean active;
    private NonNullList<ItemStack> stacks = NonNullList.withSize(1, ItemStack.EMPTY);
    private static final int[] SLOTS_IN = new int[] { 0 };

    public static Map<Item, Integer> burnTimes = AbstractFurnaceTileEntity.getBurnTimes();

    public TileGeneratorSolidFuel() {
        super(ModTileEntityTypes.GENERATOR_SOLID_FUEL);
    }

    protected final IIntArray fields = new IIntArray() {
        public int get(int i) {
            switch (i) {
                case 0:
                    return TileGeneratorSolidFuel.this.burnTime;
                case 1:
                    return TileGeneratorSolidFuel.this.recipesUsed;
                default:
                    return 0;
            }
        }
        public void set(int i, int value) {
            switch (i) {
                case 0:
                    TileGeneratorSolidFuel.this.burnTime = value;
                    break;
                case 1:
                    TileGeneratorSolidFuel.this.recipesUsed = value;
            }
        }
        public int size() {
            return 2;
        }
    };

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        ItemStackHelper.saveAllItems(compound, stacks);
        return super.write(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        stacks = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, stacks);
    }

    private LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if (!this.removed && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (facing == Direction.UP)
                return handlers[0].cast();
            else if (facing == Direction.DOWN)
                return handlers[1].cast();
            else
                return handlers[2].cast();
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("container.polymer.generator_solid_fuel");
    }

    @Override
    protected ITextComponent getDefaultName() {
        return this.getDisplayName();
    }

    @Override
    protected Container createMenu(int id, PlayerInventory playerInventory) {
        return new ContainerGeneratorSolidFuel(id, playerInventory);
    }

    @Override
    public Container createMenu(int id, PlayerInventory inventory, PlayerEntity playerEntity) {
        return new ContainerGeneratorSolidFuel(id, inventory, this, fields);
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return SLOTS_IN;
    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, Direction direction) {
        return isItemFuel(stack);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.stacks.get(0).isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.stacks.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(stacks, index, count);
    }

    public static boolean isItemFuel(ItemStack stack) {
        return AbstractFurnaceTileEntity.isFuel(stack);
    }

    private static int getFuelValue(ItemStack stack) {
        if(isItemFuel(stack)) return getBurnTime(stack);
        else return 0;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(stacks, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemstack = this.stacks.get(0);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack)
                && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.stacks.set(0, stack);
        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag) {
            this.markDirty();
        }
    }

    @Override
    public boolean isUsableByPlayer(PlayerEntity player) {
        if (this.world.getTileEntity(this.pos) != this) {
            return false;
        } else {
            return !(player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,
                    (double) this.pos.getZ() + 0.5D) > 64.0D);
        }
    }

    @Override
    public void clear() {
        this.stacks.clear();
    }

    private boolean isActive() {
        return active;
    }

    protected static int getBurnTime(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            Item item = stack.getItem();
            int ret = stack.getBurnTime();
            return net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(stack, ret == -1 ? burnTimes.getOrDefault(item, 0) : ret);
        }
    }

    @Override
    public void tick() {
        ItemStack input = stacks.get(0);
        boolean flag = active;
        boolean validFuel = !input.isEmpty() && isItemFuel(input);

        if(validFuel || burnTime > 0) {

            if(burnTime == 0) {
                recipesUsed = getFuelValue(input);
                input.shrink(1);
                active = true;
            }

            burnTime++;

            //Reset
            if(burnTime == recipesUsed) {
                recipesUsed = 0;
                burnTime = 0;
            }
        }

        else {
            active = false;
        }

        if(flag != isActive()) {
            this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).with(GeneratorSolidFuel.ACTIVE, Boolean.valueOf(this.isActive())), 3);
        }

    }

}