package com.tianyalan.testing.cdc.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tianyalan.testing.cdc.accounts.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}