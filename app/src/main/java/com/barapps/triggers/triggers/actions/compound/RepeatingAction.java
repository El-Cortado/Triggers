package com.barapps.triggers.triggers.actions.compound;

import com.barapps.triggers.triggers.actions.Action;
import com.barapps.triggers.triggers.actions.ContinuousAction;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class RepeatingAction implements ContinuousAction {

    private final static long EXECUTOR_TIMEOUT_MILLIS = 500;

    private final Action mAction;
    private final Supplier<ScheduledExecutorService> mExecutorServiceSupplier;
    private final long mDelayInSeconds;
    private final long mRateInSeconds;

    private ScheduledExecutorService mExecutorService;


    public RepeatingAction(Action action, long delayInSeconds, long rateInSeconds) {
        this(action, Executors::newSingleThreadScheduledExecutor, delayInSeconds, rateInSeconds);
    }

    public RepeatingAction(Action action,
                           Supplier<ScheduledExecutorService> executorServiceSupplier,
                           long delayInSeconds,
                           long rateInSeconds) {
        mAction = action;
        mExecutorServiceSupplier = executorServiceSupplier;
        mDelayInSeconds =  delayInSeconds;
        mRateInSeconds = rateInSeconds;
    }


    @Override
    public void execute() {
        synchronized (mAction) {
            if (null == mExecutorService) {
                mExecutorService = mExecutorServiceSupplier.get();
                mExecutorService.scheduleAtFixedRate(() -> {
                }, mDelayInSeconds, mRateInSeconds, TimeUnit.SECONDS);
            }
        }
    }

    @Override
    public void stop() {
        synchronized (mAction) {
            if (null != mExecutorService) {
                mExecutorService.shutdownNow();
                try {
                    mExecutorService.awaitTermination(EXECUTOR_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                } catch (InterruptedException ignored) { }
                mExecutorService = null;
            }
        }
    }

}
