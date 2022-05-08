import { Component, OnInit,Output,EventEmitter } from '@angular/core';
import { Injectable } from '@angular/core';
import { Subscription } from 'rxjs';

import { UserService } from 'src/app/services/user.service';
import { User } from 'src/User';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
@Injectable()
export class LoginComponent implements OnInit {
  myUser:  | undefined;
  userName!: string;
  password!: string;
  subscription: Subscription | undefined;

  user: User = {
    userName: this.userName,
    password: this.password,
    firstName: '',
    lastName: '',
    age: 0,
    userRole: ''
  };

  constructor(private userService: UserService) {
    
  }

  ngOnInit(): void {}
  onSubmit() {
    if (!this.userName) {
      alert('please add userName!');
      return;
    }
const userInfo:User = {
  userName: this.userName,
  password: this.password,
  firstName: '',
  lastName: '',
  age: 0,
  userRole: '',
};
    this.userService
      .loginUser()
      .subscribe((user) => (console.log(user)));
    console.log(this.myUser);
    // this.userName = '';
    // this.password = '';
  }
}
