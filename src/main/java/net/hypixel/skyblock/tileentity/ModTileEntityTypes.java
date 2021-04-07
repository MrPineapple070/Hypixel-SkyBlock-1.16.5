package net.hypixel.skyblock.tileentity;

import net.hypixel.skyblock.HypixelSkyBlockMod;
import net.hypixel.skyblock.blocks.init.BlockInit;
import net.hypixel.skyblock.blocks.init.MinionBlockInit;
import net.hypixel.skyblock.tileentity.TimeSaverTileEntity.DaySaverTileEntity;
import net.hypixel.skyblock.tileentity.TimeSaverTileEntity.NightSaverTileEntity;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionChestTileEntity.LargeMCTE;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionChestTileEntity.MediumMCTE;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionChestTileEntity.SmallMCTE;
import net.hypixel.skyblock.tileentity.minion.AbstractMinionTileEntity.MinionTier;
import net.hypixel.skyblock.tileentity.minion.AcaciaMinionTileEntity;
import net.hypixel.skyblock.tileentity.minion.BirchMinionTileEntity;
import net.hypixel.skyblock.tileentity.minion.BlazeMinionTileEntity;
import net.hypixel.skyblock.tileentity.minion.CoalMinionTileEntity;
import net.hypixel.skyblock.tileentity.minion.CobblestoneMinionTileEntity;
import net.hypixel.skyblock.tileentity.minion.IronMinionTileEntity;
import net.hypixel.skyblock.tileentity.minion.WheatMinionTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntityType.Builder;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Initialize and Register all {@link TileEntityType} for this mod.
 *
 * @author MrPineapple070
 * @version 5 June 2020
 * @since 11 June 2019
 */
public class ModTileEntityTypes {
	public static final DeferredRegister<TileEntityType<?>> tile_entity_types = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, HypixelSkyBlockMod.MOD_ID);

	public static final RegistryObject<TileEntityType<AcaciaMinionTileEntity>> acacia_minion_1 = tile_entity_types
			.register("acacia_minion_1",
					() -> Builder.of(AcaciaMinionTileEntity::new, MinionBlockInit.acacia_minion_1.get()).build(null));
	public static final RegistryObject<TileEntityType<AcaciaMinionTileEntity>> acacia_minion_2 = tile_entity_types
			.register("acacia_minion_2",
					() -> Builder.of(AcaciaMinionTileEntity::tier2, MinionBlockInit.acacia_minion_2.get()).build(null));
	public static final RegistryObject<TileEntityType<AcaciaMinionTileEntity>> acacia_minion_3 = tile_entity_types
			.register("acacia_minion_3",
					() -> Builder.of(AcaciaMinionTileEntity::tier3, MinionBlockInit.acacia_minion_3.get()).build(null));
	public static final RegistryObject<TileEntityType<AcaciaMinionTileEntity>> acacia_minion_4 = tile_entity_types
			.register("acacia_minion_4",
					() -> Builder.of(AcaciaMinionTileEntity::tier4, MinionBlockInit.acacia_minion_4.get()).build(null));
	public static final RegistryObject<TileEntityType<AcaciaMinionTileEntity>> acacia_minion_5 = tile_entity_types
			.register("acacia_minion_5",
					() -> Builder.of(AcaciaMinionTileEntity::tier5, MinionBlockInit.acacia_minion_5.get()).build(null));
	public static final RegistryObject<TileEntityType<AcaciaMinionTileEntity>> acacia_minion_6 = tile_entity_types
			.register("acacia_minion_6",
					() -> Builder.of(AcaciaMinionTileEntity::tier6, MinionBlockInit.acacia_minion_6.get()).build(null));
	public static final RegistryObject<TileEntityType<AcaciaMinionTileEntity>> acacia_minion_7 = tile_entity_types
			.register("acacia_minion_7",
					() -> Builder.of(AcaciaMinionTileEntity::tier7, MinionBlockInit.acacia_minion_7.get()).build(null));
	public static final RegistryObject<TileEntityType<AcaciaMinionTileEntity>> acacia_minion_8 = tile_entity_types
			.register("acacia_minion_8",
					() -> Builder.of(AcaciaMinionTileEntity::tier8, MinionBlockInit.acacia_minion_8.get()).build(null));
	public static final RegistryObject<TileEntityType<AcaciaMinionTileEntity>> acacia_minion_9 = tile_entity_types
			.register("acacia_minion_9",
					() -> Builder.of(AcaciaMinionTileEntity::tier9, MinionBlockInit.acacia_minion_9.get()).build(null));
	public static final RegistryObject<TileEntityType<AcaciaMinionTileEntity>> acacia_minion_a = tile_entity_types
			.register("acacia_minion_a",
					() -> Builder.of(AcaciaMinionTileEntity::tiera, MinionBlockInit.acacia_minion_a.get()).build(null));
	public static final RegistryObject<TileEntityType<AcaciaMinionTileEntity>> acacia_minion_b = tile_entity_types
			.register("acacia_minion_b",
					() -> Builder.of(AcaciaMinionTileEntity::tierb, MinionBlockInit.acacia_minion_b.get()).build(null));

	public static final RegistryObject<TileEntityType<BirchMinionTileEntity>> birch_minion = tile_entity_types.register(
			"birch_minion",
			() -> Builder.of(BirchMinionTileEntity::new, MinionBlockInit.birch_minion_1.get()).build(null));
	public static final RegistryObject<TileEntityType<BirchMinionTileEntity>> birch_minion_2 = tile_entity_types
			.register("birch_minion_2",
					() -> Builder.of(BirchMinionTileEntity::tier2, MinionBlockInit.birch_minion_2.get()).build(null));
	public static final RegistryObject<TileEntityType<BirchMinionTileEntity>> birch_minion_3 = tile_entity_types
			.register("birch_minion_3",
					() -> Builder.of(BirchMinionTileEntity::tier3, MinionBlockInit.birch_minion_2.get()).build(null));
	public static final RegistryObject<TileEntityType<BirchMinionTileEntity>> birch_minion_4 = tile_entity_types
			.register("birch_minion_4",
					() -> Builder.of(BirchMinionTileEntity::tier4, MinionBlockInit.birch_minion_2.get()).build(null));
	public static final RegistryObject<TileEntityType<BirchMinionTileEntity>> birch_minion_5 = tile_entity_types
			.register("birch_minion_5",
					() -> Builder.of(BirchMinionTileEntity::tier5, MinionBlockInit.birch_minion_2.get()).build(null));
	public static final RegistryObject<TileEntityType<BirchMinionTileEntity>> birch_minion_6 = tile_entity_types
			.register("birch_minion_6",
					() -> Builder.of(BirchMinionTileEntity::tier6, MinionBlockInit.birch_minion_2.get()).build(null));
	public static final RegistryObject<TileEntityType<BirchMinionTileEntity>> birch_minion_7 = tile_entity_types
			.register("birch_minion_7",
					() -> Builder.of(BirchMinionTileEntity::tier7, MinionBlockInit.birch_minion_2.get()).build(null));
	public static final RegistryObject<TileEntityType<BirchMinionTileEntity>> birch_minion_8 = tile_entity_types
			.register("birch_minion_8",
					() -> Builder.of(BirchMinionTileEntity::tier8, MinionBlockInit.birch_minion_2.get()).build(null));
	public static final RegistryObject<TileEntityType<BirchMinionTileEntity>> birch_minion_9 = tile_entity_types
			.register("birch_minion_9",
					() -> Builder.of(BirchMinionTileEntity::tier9, MinionBlockInit.birch_minion_2.get()).build(null));
	public static final RegistryObject<TileEntityType<BirchMinionTileEntity>> birch_minion_a = tile_entity_types
			.register("birch_minion_a",
					() -> Builder.of(BirchMinionTileEntity::tiera, MinionBlockInit.birch_minion_2.get()).build(null));
	public static final RegistryObject<TileEntityType<BirchMinionTileEntity>> birch_minion_b = tile_entity_types
			.register("birch_minion_b",
					() -> Builder.of(BirchMinionTileEntity::tierb, MinionBlockInit.birch_minion_2.get()).build(null));

	public static final RegistryObject<TileEntityType<BlazeMinionTileEntity>> blaze_minion_1 = tile_entity_types.register(
			"blaze_minion_1",
			() -> Builder.of(BlazeMinionTileEntity::new, MinionBlockInit.blaze_minion_1.get()).build(null));
	public static final RegistryObject<TileEntityType<BlazeMinionTileEntity>> blaze_minion_2 = tile_entity_types
			.register("blaze_minion_2",
					() -> Builder
							.of(() -> new BlazeMinionTileEntity(MinionTier.II), MinionBlockInit.blaze_minion_2.get())
							.build(null));
	public static final RegistryObject<TileEntityType<BlazeMinionTileEntity>> blaze_minion_3 = tile_entity_types
			.register("blaze_minion_3",
					() -> Builder
							.of(() -> new BlazeMinionTileEntity(MinionTier.III), MinionBlockInit.blaze_minion_2.get())
							.build(null));
	public static final RegistryObject<TileEntityType<BlazeMinionTileEntity>> blaze_minion_4 = tile_entity_types
			.register("blaze_minion_4",
					() -> Builder
							.of(() -> new BlazeMinionTileEntity(MinionTier.IV), MinionBlockInit.blaze_minion_2.get())
							.build(null));
	public static final RegistryObject<TileEntityType<BlazeMinionTileEntity>> blaze_minion_5 = tile_entity_types
			.register("blaze_minion_5",
					() -> Builder
							.of(() -> new BlazeMinionTileEntity(MinionTier.V), MinionBlockInit.blaze_minion_2.get())
							.build(null));
	public static final RegistryObject<TileEntityType<BlazeMinionTileEntity>> blaze_minion_6 = tile_entity_types
			.register("blaze_minion_6",
					() -> Builder
							.of(() -> new BlazeMinionTileEntity(MinionTier.VI), MinionBlockInit.blaze_minion_2.get())
							.build(null));
	public static final RegistryObject<TileEntityType<BlazeMinionTileEntity>> blaze_minion_7 = tile_entity_types
			.register("blaze_minion_7",
					() -> Builder
							.of(() -> new BlazeMinionTileEntity(MinionTier.VII), MinionBlockInit.blaze_minion_2.get())
							.build(null));
	public static final RegistryObject<TileEntityType<BlazeMinionTileEntity>> blaze_minion_8 = tile_entity_types
			.register("blaze_minion_8",
					() -> Builder
							.of(() -> new BlazeMinionTileEntity(MinionTier.VIII), MinionBlockInit.blaze_minion_2.get())
							.build(null));
	public static final RegistryObject<TileEntityType<BlazeMinionTileEntity>> blaze_minion_9 = tile_entity_types
			.register("blaze_minion_9",
					() -> Builder
							.of(() -> new BlazeMinionTileEntity(MinionTier.IX), MinionBlockInit.blaze_minion_2.get())
							.build(null));
	public static final RegistryObject<TileEntityType<BlazeMinionTileEntity>> blaze_minion_a = tile_entity_types
			.register("blaze_minion_a",
					() -> Builder
							.of(() -> new BlazeMinionTileEntity(MinionTier.X), MinionBlockInit.blaze_minion_2.get())
							.build(null));
	public static final RegistryObject<TileEntityType<BlazeMinionTileEntity>> blaze_minion_b = tile_entity_types
			.register("blaze_minion_b",
					() -> Builder
							.of(() -> new BlazeMinionTileEntity(MinionTier.XI), MinionBlockInit.blaze_minion_2.get())
							.build(null));

	public static final RegistryObject<TileEntityType<CoalMinionTileEntity>> coal_minion = tile_entity_types.register(
			"coal_minion",
			() -> Builder.of(CoalMinionTileEntity::new, MinionBlockInit.coal_minion_1.get(),
					MinionBlockInit.coal_minion_2.get(), MinionBlockInit.coal_minion_3.get(),
					MinionBlockInit.coal_minion_4.get(), MinionBlockInit.coal_minion_5.get(),
					MinionBlockInit.coal_minion_6.get(), MinionBlockInit.coal_minion_7.get(),
					MinionBlockInit.coal_minion_8.get(), MinionBlockInit.coal_minion_9.get(),
					MinionBlockInit.coal_minion_a.get(), MinionBlockInit.coal_minion_b.get()).build(null));

	public static final RegistryObject<TileEntityType<CobblestoneMinionTileEntity>> cobblestone_minion = tile_entity_types
			.register("cobblestone_minion",
					() -> Builder.of(CobblestoneMinionTileEntity::new, MinionBlockInit.cobblestone_minion_1.get(),
							MinionBlockInit.cobblestone_minion_2.get(), MinionBlockInit.cobblestone_minion_3.get(),
							MinionBlockInit.cobblestone_minion_4.get(), MinionBlockInit.cobblestone_minion_5.get(),
							MinionBlockInit.cobblestone_minion_6.get(), MinionBlockInit.cobblestone_minion_7.get(),
							MinionBlockInit.cobblestone_minion_8.get(), MinionBlockInit.cobblestone_minion_9.get(),
							MinionBlockInit.cobblestone_minion_a.get(), MinionBlockInit.cobblestone_minion_b.get())
							.build(null));

	public static final RegistryObject<TileEntityType<IronMinionTileEntity>> iron_minion = tile_entity_types.register(
			"iron_minion",
			() -> Builder.of(IronMinionTileEntity::new, MinionBlockInit.iron_minion_1.get(),
					MinionBlockInit.iron_minion_2.get(), MinionBlockInit.iron_minion_3.get(),
					MinionBlockInit.iron_minion_4.get(), MinionBlockInit.iron_minion_5.get(),
					MinionBlockInit.iron_minion_6.get(), MinionBlockInit.iron_minion_7.get(),
					MinionBlockInit.iron_minion_8.get(), MinionBlockInit.iron_minion_9.get(),
					MinionBlockInit.iron_minion_a.get(), MinionBlockInit.iron_minion_b.get()).build(null));

	public static final RegistryObject<TileEntityType<WheatMinionTileEntity>> wheat_minion = tile_entity_types.register(
			"wheat_minion",
			() -> Builder.of(WheatMinionTileEntity::new, MinionBlockInit.wheat_minion_1.get(),
					MinionBlockInit.wheat_minion_2.get(), MinionBlockInit.wheat_minion_3.get(),
					MinionBlockInit.wheat_minion_4.get(), MinionBlockInit.wheat_minion_5.get(),
					MinionBlockInit.wheat_minion_6.get(), MinionBlockInit.wheat_minion_7.get(),
					MinionBlockInit.wheat_minion_8.get(), MinionBlockInit.wheat_minion_9.get(),
					MinionBlockInit.wheat_minion_a.get(), MinionBlockInit.wheat_minion_a.get()).build(null));

	public static final RegistryObject<TileEntityType<DaySaverTileEntity>> day_saver = tile_entity_types
			.register("day_saver", () -> Builder.of(DaySaverTileEntity::new, BlockInit.day_saver.get()).build(null));
	public static final RegistryObject<TileEntityType<NightSaverTileEntity>> night_saver = tile_entity_types.register(
			"night_saver", () -> Builder.of(NightSaverTileEntity::new, BlockInit.night_saver.get()).build(null));

	public static final RegistryObject<TileEntityType<SmallMCTE>> small_mcte = tile_entity_types.register("small_mcte",
			() -> Builder.of(SmallMCTE::new, BlockInit.small_mcb.get()).build(null));
	public static final RegistryObject<TileEntityType<MediumMCTE>> medium_mcte = tile_entity_types
			.register("medium_mcte", () -> Builder.of(MediumMCTE::new, BlockInit.medium_mcb.get()).build(null));
	public static final RegistryObject<TileEntityType<LargeMCTE>> large_mcte = tile_entity_types.register("large_mcte",
			() -> Builder.of(LargeMCTE::new, BlockInit.large_mcb.get()).build(null));
}