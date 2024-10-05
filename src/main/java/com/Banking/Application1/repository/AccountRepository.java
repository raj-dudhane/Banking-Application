package com.Banking.Application1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Banking.Application1.dto.AccountDto;
import com.Banking.Application1.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{



	

}
