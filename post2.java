// STAR-CCM+ macro: post2.java
// Written by STAR-CCM+ 13.06.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;

public class post2 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSceneManager().createScalarScene("Scalar Scene", "Outline", "Scalar");

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_1.initializeAndWait();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_0.initialize();

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_1.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_0.initialize();

    Legend legend_0 = 
      scalarDisplayer_0.getLegend();

    BlueRedLookupTable blueRedLookupTable_0 = 
      ((BlueRedLookupTable) simulation_0.get(LookupTableManager.class).getObject("blue-red"));

    legend_0.setLookupTable(blueRedLookupTable_0);

    SceneUpdate sceneUpdate_0 = 
      scene_1.getSceneUpdate();

    HardcopyProperties hardcopyProperties_0 = 
      sceneUpdate_0.getHardcopyProperties();

    hardcopyProperties_0.setCurrentResolutionWidth(1086);

    hardcopyProperties_0.setCurrentResolutionHeight(646);

    scene_1.resetCamera();

    partDisplayer_0.setDataFocus(null);

    partDisplayer_0.getInputParts().setQuery(null);

    MeshOperationPart meshOperationPart_0 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("Subtract"));

    PartSurface partSurface_0 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("car.Body1._rl_rlwheel_1"));

    PartSurface partSurface_1 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("car.Body1._rl_rlwheel_2"));

    PartSurface partSurface_2 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("car.Body1._rl_rlwheel_3"));

    PartSurface partSurface_3 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("car.Body1._rl_rlwheel_4"));

    PartSurface partSurface_4 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("car.Body1._rl_rlwheel_5"));

    PartSurface partSurface_5 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("car.Body3._fl_flwheel_1"));

    PartSurface partSurface_6 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("car.Body3._fl_flwheel_2"));

    PartSurface partSurface_7 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("car.Body3._fl_flwheel_3"));

    PartSurface partSurface_8 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("car.Body3._fl_flwheel_4"));

    PartSurface partSurface_9 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("car.Body3._fl_flwheel_5"));

    PartSurface partSurface_10 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("car.Body5._wall_head_1_rep"));

    PartSurface partSurface_11 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("car.Body5._wall_head_2_rep"));

    PartSurface partSurface_12 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("car.Body5.Faces"));

    PartCurve partCurve_0 = 
      meshOperationPart_0.getPartCurveManager().getPartCurve("car.Body5.Edges");

    partDisplayer_0.getInputParts().setObjects(partSurface_0, partSurface_1, partSurface_2, partSurface_3, partSurface_4, partSurface_5, partSurface_6, partSurface_7, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partCurve_0);

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    scene_1.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    PartDisplayer partDisplayer_1 = 
      ((PartDisplayer) scene_1.getCreatorDisplayer());

    partDisplayer_1.initialize();

    scene_1.getCreatorGroup().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region 1");

    scene_1.getCreatorGroup().setObjects(region_0);

    PartDisplayer partDisplayer_2 = 
      scene_1.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

    partDisplayer_2.initialize();

    scene_1.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    PlaneSection planeSection_0 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    planeSection_0.setCoordinateSystem(labCoordinateSystem_0);

    planeSection_0.getInputParts().setQuery(null);

    planeSection_0.getInputParts().setObjects(region_0);

    Coordinate coordinate_0 = 
      planeSection_0.getOriginCoordinate();

    coordinate_0.setValue(new DoubleVector(new double[] {0.0, 0.5442816851088049, 1.0443865241159203}));

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.5442816851088049, 1.0443865241159203}));

    coordinate_0.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_1 = 
      planeSection_0.getOrientationCoordinate();

    coordinate_1.setValue(new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    coordinate_1.setCoordinateSystem(labCoordinateSystem_0);

    SingleValue singleValue_0 = 
      planeSection_0.getSingleValue();

    singleValue_0.getValueQuantity().setValue(0.0);

    singleValue_0.getValueQuantity().setUnits(units_0);

    RangeMultiValue rangeMultiValue_0 = 
      planeSection_0.getRangeMultiValue();

    rangeMultiValue_0.setNValues(2);

    rangeMultiValue_0.getStartQuantity().setValue(0.0);

    rangeMultiValue_0.getStartQuantity().setUnits(units_0);

    rangeMultiValue_0.getEndQuantity().setValue(1.0);

    rangeMultiValue_0.getEndQuantity().setUnits(units_0);

    DeltaMultiValue deltaMultiValue_0 = 
      planeSection_0.getDeltaMultiValue();

    deltaMultiValue_0.setNValues(2);

    deltaMultiValue_0.getStartQuantity().setValue(0.0);

    deltaMultiValue_0.getStartQuantity().setUnits(units_0);

    deltaMultiValue_0.getDeltaQuantity().setValue(1.0);

    deltaMultiValue_0.getDeltaQuantity().setUnits(units_0);

    MultiValue multiValue_0 = 
      planeSection_0.getArbitraryMultiValue();

    multiValue_0.getValueQuantities().setUnits(units_0);

    multiValue_0.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_0.setValueMode(ValueMode.SINGLE);

    partDisplayer_2.getVisibleParts().addParts(planeSection_0);

    partDisplayer_2.getHiddenParts().addParts();

    scene_1.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);

    CurrentView currentView_0 = 
      scene_1.getCurrentView();

    VisView visView_0 = 
      ((VisView) simulation_0.getViewManager().getObject("View 1"));

    currentView_0.setView(visView_0);

    scene_1.getDisplayerManager().deleteDisplayers(new NeoObjectVector(new Object[] {partDisplayer_2}));

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Geometry", 1);

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    scene_2.initializeAndWait();

    PartDisplayer partDisplayer_3 = 
      ((PartDisplayer) scene_2.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_3.initialize();

    PartDisplayer partDisplayer_4 = 
      ((PartDisplayer) scene_2.getDisplayerManager().getDisplayer("Geometry 1"));

    partDisplayer_4.initialize();

    SceneUpdate sceneUpdate_1 = 
      scene_2.getSceneUpdate();

    HardcopyProperties hardcopyProperties_1 = 
      sceneUpdate_1.getHardcopyProperties();

    hardcopyProperties_1.setCurrentResolutionWidth(25);

    hardcopyProperties_1.setCurrentResolutionHeight(25);

    hardcopyProperties_0.setCurrentResolutionWidth(1088);

    hardcopyProperties_0.setCurrentResolutionHeight(647);

    hardcopyProperties_1.setCurrentResolutionWidth(1086);

    hardcopyProperties_1.setCurrentResolutionHeight(646);

    scene_2.resetCamera();
  }
}
