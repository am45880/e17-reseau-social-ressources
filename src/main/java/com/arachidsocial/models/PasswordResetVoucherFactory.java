package com.arachidsocial.models;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

/**
 * Created by Benoit on 2017-06-09.
 */
public class PasswordResetVoucherFactory {
    private static final Duration DEFAULT_PASSWORD_RESET_VOUCHER_VALIDITY_DURATION = Duration.ofDays(3);

    public PasswordResetVoucher createPasswordResetVoucherFor(String emailAddress) {
        return new PasswordResetVoucher()
                .withEmailAddress(emailAddress)
                .withDeliveryInstant(Instant.now())
                .withPasswordResetToken(UUID.randomUUID().toString().replace("-", ""))
                .withValidity(DEFAULT_PASSWORD_RESET_VOUCHER_VALIDITY_DURATION);
    }
}
