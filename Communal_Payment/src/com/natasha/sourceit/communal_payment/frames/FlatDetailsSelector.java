package com.natasha.sourceit.communal_payment.frames;

/**
 * Created by Stas on 08.02.2017.
 */
public class FlatDetailsSelector {

    private long flatId;

    private Thread tth;
    FlatsByAddressContent gui;

    public FlatDetailsSelector(long flatId) {
        this.flatId = flatId;
    }

    public void fillInUi(FlatsByAddressContent gui) {
        this.gui = gui;
        if (tth != null) throw new IllegalStateException("Already used");

        tth = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doJob();
                } catch (Exception e) {
                    gui.showError(e.getMessage());
                }
            }
        });
        tth.start();
    }

    private void doJob() throws Exception {
        Thread.sleep(250);
        gui.setFlatDetails("TODO Implement details for flatID="+flatId);
    }
}
