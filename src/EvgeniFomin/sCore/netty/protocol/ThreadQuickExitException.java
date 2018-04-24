package EvgeniFomin.sCore.netty.protocol;

public final class ThreadQuickExitException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private ThreadQuickExitException() {
        this.setStackTrace(new StackTraceElement[0]);
    }
}