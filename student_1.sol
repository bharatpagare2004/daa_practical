
//SPDX-License-Identifier:UNLICENSED
pragma solidity ^0.8.0;

contract Studentdata{

    struct Student{
        string name;
        uint rollno;
    }

    Student[] public studentArr;

    function addstudent(string memory name , uint rollno) public{
        for(uint i = 0;i<studentArr.length;i++)
        {
            if(studentArr[i].rollno == rollno)
            {
               revert("all ready exist");
            }
        }
        studentArr.push(Student(name,rollno));
    }
    function show_all_student() public view returns (Student[] memory)
    {
        return studentArr;
    }
    function getStudentrollno(uint rollno) public view returns (Student memory) {
    for (uint i = 0; i < studentArr.length; i++) {
        if (studentArr[i].rollno == rollno) {
            return studentArr[i]; // return matching student
        }
    }
    revert("Student not found"); // if no student with this rollno exists
}

  

    fallback() external payable{
        revert("You cannot send ether to this contract");
    }
    receive() external payable {

     }
}