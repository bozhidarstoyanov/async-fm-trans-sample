package com.bozhidarstoyanov.fragmenttransactions.custom.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Message Handler class that supports buffering up of messages on occasions.
 *
 * @author bozhidar.stoyanov
 */
public abstract class RetainingHandler extends Handler {

    /**
     * Message Queue Buffer
     */
    private final Deque<Message> mMessageQueueBuffer = new ArrayDeque<Message>();

    public RetainingHandler() {

    }

    public RetainingHandler(Looper looper) {

        super(looper);
    }

    public RetainingHandler(Callback callback) {

        super(callback);
    }

    public RetainingHandler(Looper looper, Callback callback) {

        super(looper, callback);
    }

    /**
     * Handle kept messages
     */
    public final void handlePendingMessages() {

        while (!mMessageQueueBuffer.isEmpty()) {

            sendMessage(mMessageQueueBuffer.pollFirst());
        }
    }

    /**
     * Message to be handled is going to be either stored for later processing
     * using {@link #handlePendingMessages() handlePendingMessages()}, or
     * directly processed, depending on storeMessage return value
     *
     * @param message - the message to be handled
     */
    @Override
    public final void handleMessage(Message message) {

        if (!this.validateMessage(message)) {

            this.dispose(message);
        } else if (this.storeMessage(message)) {

            this.store(message);
        } else {

            this.processMessage(message);
            this.dispose(message);
        }
    }

	/* Abstract Methods */

    /**
     * Used for determining if a message is eligible to continue its handling.
     *
     * @param message - the message which is being handled
     */
    protected abstract boolean validateMessage(Message message);

    /**
     * Used for determining if a message needs to be stored or directly
     * processed at the time of handling.
     *
     * @param message - the message which is being handled
     * @return true if the message has to be stored
     */
    protected abstract boolean storeMessage(Message message);

    /**
     * Notification message to be processed. This will either be directly from
     * {@link #handleMessage(Message) handleMessage(Message)} or played back
     * from saved messages when {@link #handlePendingMessages()
     * handlePendingMessages()} is called
     *
     * @param message - the message to be processed
     */
    protected abstract void processMessage(Message message);

	/* Private Methods */

    private void store(Message message) {

        if (!this.mMessageQueueBuffer.contains(message)) {

            Message msgCopy = new Message();
            msgCopy.copyFrom(message);
            this.mMessageQueueBuffer.offer(msgCopy);
        }
    }

    private void dispose(Message message) {

        if (this.mMessageQueueBuffer.contains(message)) {

            this.mMessageQueueBuffer.remove(message);
        }
        message.obj = null;
        message.replyTo = null;
        message.setData(null);
        message.setTarget(null);
    }
}
