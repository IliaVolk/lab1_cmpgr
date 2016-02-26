package input;

import GUI.Frame;

public class InputManager {
    private GLEventListenerImpl glEventListener;
    private GlobalMouseListener globalMouseListener;
    private Context context = new Context();
    private FormHandler formHandler  = new FormHandler(context);


    public Context getContext() {
        return context;
    }

    public GLEventListenerImpl getGlEventListener() {
        return glEventListener;
    }

    public void setGlEventListener(GLEventListenerImpl glEventListener) {
        this.glEventListener = glEventListener;
    }

    public GlobalMouseListener getGlobalMouseListener() {
        return globalMouseListener;
    }

    public void setGlobalMouseListener(GlobalMouseListener globalMouseListener) {
        this.globalMouseListener = globalMouseListener;
    }

    public FormHandler getFormHandler() {
        return formHandler;
    }

    public void setFormHandler(FormHandler formHandler) {
        this.formHandler = formHandler;
    }
}
