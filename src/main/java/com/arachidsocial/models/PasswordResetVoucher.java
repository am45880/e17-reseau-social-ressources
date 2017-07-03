package com.arachidsocial.models;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by Benoit on 2017-06-09.
 */
public class PasswordResetVoucher {
    private String emailAddress;
    private String passwordResetToken;
    private Instant deliveryDate;
    private Duration validityDuration;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public Instant getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Instant deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Duration getValidityDuration() {
        return validityDuration;
    }

    public void setValidityDuration(Duration validityDuration) {
        this.validityDuration = validityDuration;
    }

    public PasswordResetVoucher withEmailAddress(String emailAddress) {
        setEmailAddress(emailAddress);
        return this;
    }

    public PasswordResetVoucher withPasswordResetToken(String passwordResetToken) {
        setPasswordResetToken(passwordResetToken);
        return this;
    }

    public PasswordResetVoucher withDeliveryInstant(Instant deliveryInstant) {
        setDeliveryDate(deliveryInstant);
        return this;
    }

    public PasswordResetVoucher withValidity(Duration validity) {
        setValidityDuration(validity);
        return this;
    }

    public boolean isValid() {
        return Instant.now().isBefore(deliveryDate.plus(validityDuration));
    }
}
