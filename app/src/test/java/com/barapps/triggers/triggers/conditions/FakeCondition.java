package com.barapps.triggers.triggers.conditions;

public class FakeCondition implements Condition {

    private boolean mIsVerified;

    public FakeCondition(boolean isVerified) {
        mIsVerified = isVerified;
    }

    @Override
    public boolean test() {
        return mIsVerified;
    }

    public void set(boolean isVerified) {
        mIsVerified = isVerified;
    }
}
