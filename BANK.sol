// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

contract Bank {
    address public accOwner;
    uint256 public balance = 0;

    constructor() {
        accOwner = msg.sender;
    }

    // Deposit Ether into the account
    function deposit() public payable {
        require(accOwner == msg.sender, "You are not the account owner!");
        require(msg.value > 0, "Deposit amount must be greater than 0.");
        balance += msg.value;
    }

    // Withdraw Ether from the account
    function withdraw(uint256 amount) public {
        require(accOwner == msg.sender, "You are not the account owner!");
        require(amount <= balance, "Insufficient balance!");
        balance -= amount;
        payable(msg.sender).transfer(amount);
    }

    // Show current balance
    function showBalance() public view returns (uint256) {
        require(accOwner == msg.sender, "You are not the account owner!");
        return balance;
    }
}
