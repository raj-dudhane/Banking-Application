package com.Banking.Application1.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Banking.Application1.dto.AccountDto;
import com.Banking.Application1.service.AccountService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/accountss")
public class AccountController1 {
	
	private static final Map<String, Double> request = null;
	private AccountService accountService;
	private Long Id;
	
	
	
	public AccountController1(AccountService accountService) {
		super();
		this.accountService = accountService;
	}


	//add accunt rest api
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
	
	
	return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
		
}
	@GetMapping("/{Id}")
	public ResponseEntity<AccountDto> getAccountById (@PathVariable Long Id){
		
		AccountDto accountdto= accountService.getAccountById(Id);
		
		return ResponseEntity.ok(accountdto);
	}
	

	@PutMapping("{Id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long Id,@RequestBody Map<String, Double> request){
	
	
		AccountDto accountDto=accountService.deposit(Id, request.get("amount"));
		
	
	return ResponseEntity.ok(accountDto);
	
	
	}
	
	@PutMapping("{Id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long Id,@RequestBody Map<String,Double> request){
		
			Double amount=request.get("amount");
			AccountDto accountDto=accountService.withdraw(Id, amount);
			return ResponseEntity.ok(accountDto);
		
		
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<AccountDto>>getAllAccounts(){
		
	List<AccountDto> accountDto=accountService.getAllAccounts();
	
	return ResponseEntity.ok(accountDto);

	
	}
	@DeleteMapping("/{Id}")
	public ResponseEntity<String>deleteAccount(@PathVariable Long Id){
		
		accountService.deleteAccount(Id);
		
		return ResponseEntity.ok("Account Deleted Successfully!!");
		
	}
	
	

	
	
}