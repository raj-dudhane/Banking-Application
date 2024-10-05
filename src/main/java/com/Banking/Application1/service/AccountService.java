package com.Banking.Application1.service;


import java.util.List;

import com.Banking.Application1.dto.AccountDto;

public interface AccountService {

		AccountDto createAccount(AccountDto account);
		
		AccountDto getAccountById(Long Id);
		
		AccountDto deposit(Long Id, double amount);
		
		AccountDto withdraw(Long Id,double amount);

		List<AccountDto> getAllAccounts();
		
		void deleteAccount(Long Id);
}
