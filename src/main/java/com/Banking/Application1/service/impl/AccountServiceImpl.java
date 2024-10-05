package com.Banking.Application1.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Banking.Application1.dto.AccountDto;
import com.Banking.Application1.entity.Account;
import com.Banking.Application1.mapper.AccountMapper;
import com.Banking.Application1.repository.AccountRepository;
import com.Banking.Application1.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	
	
	private AccountRepository accountRepository;
		

	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}



	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		
		Account account=AccountMapper.mapToAccount(accountDto);
		 Account savedAccount=accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}


	@Override
	public AccountDto getAccountById(Long Id) {
		
		Account account=accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("Account Does Not Exit"));
		
		return AccountMapper.mapToAccountDto(account);
	}



	@Override
	public AccountDto deposit(Long Id, double amount) {
	
			
		Account account=accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("Account Does Not Exit"));

		double totalBalance=account.getBalance()+amount;
		account.setBalance(totalBalance);
		Account savedAccount=accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public AccountDto withdraw(Long Id, double amount) {
		
		Account account=accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("Account Does Not Exit"));

		if(account.getBalance()< amount) {
			
			throw new RuntimeException("Insufficient Balance");
			
		}
	double total=account.getBalance()-amount;
	account.setBalance(total);
	Account savedAccount=accountRepository.save(account);
	
	
		return AccountMapper.mapToAccountDto(savedAccount);
		
	
		
		
	}



	@Override
	public List<AccountDto> getAllAccounts() {
		
		
		return (List<AccountDto>) accountRepository.findAll().stream().map((account)->AccountMapper
					.mapToAccountDto(account)).collect(Collectors.toList());		
	}



	@Override
	public void deleteAccount(Long Id) {
		
		Account account=accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("Account Does Not Exit"));

		accountRepository.delete(account);
		
	}



	
	

}
