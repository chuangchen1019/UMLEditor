package Modes;
import Editor.CanvasArea.CanvasListener;
import Modes.line.AssociationMode;
import Modes.line.CompositionMode;
import Modes.line.GeneralizationMode;
import Modes.object.*;


public class ModeManager {
    public final static int SELECT = 0;
    public final static int ASSOCIATION = 1;
    public final static int GENERALIZATION = 2;
    public final static int COMPOSITION = 3;
    public final static int CLASS = 4;
    public final static int USECASE = 5;
    private static int modeIndex = 0;
    private static CanvasListener cListener = CanvasListener.getInstance();


    public final static String[] modeNames = {
        "SELECT", 
        "ASSOCIATION", 
        "GENERALIZATION", 
        "COMPOSITION", 
        "CLASS", 
        "USECASE"
    };

    private final static Mode[] modeList = {
        new SelectionMode(),
        new AssociationMode(),
        new GeneralizationMode(),
        new CompositionMode(),
        new ClassMode(),
        new UseCaseMode()
    };

    public static String getModeName(int idx){
        return modeNames[idx];
    }

    public static int getNumberOfModes() {
        return modeNames.length;
    }

    public static int getMode(){
        return modeIndex;
    }

    public static void setMode(int idx){
        modeIndex = idx;
        if (modeList[idx] instanceof Mode) {
            System.out.println("Moddddd");

        }
        if (modeList[idx] != null) {
            System.out.println("Mode had something!");
            cListener.setMode(modeList[idx]);
        } else {
            System.out.println("Err: mode is null");
        }
    }
}
