package com.payments.walletservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for wallet operations
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {

    /**
     * Get the wallet
     *
     * @return the wallet
     */
    @GetMapping("/get")
    public ResponseEntity<String> getWallet() {
        return ResponseEntity.status(200).body("Wallet");
    }
}
