import { Component, Inject } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-users-dialog-form',
  templateUrl: './users-dialog-form.component.html',
  styleUrls: ['./users-dialog-form.component.scss'],
})
export class UsersDialogFormComponent {
  
  form = new FormGroup({
    name: new FormControl('', [Validators.required]),
    username: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required]),
    repeatPassword: new FormControl('', [Validators.required]),
    roles: new FormControl('', [Validators.required]),
    active: new FormControl(true),
  });

  hide = true;

  constructor(
    public dialogRef: MatDialogRef<UsersDialogFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  getErrorMessage() {
    if (this.form.get('email')?.hasError('required')) {
      return 'You must enter a value';
    }

    return this.form.get('email')?.hasError('email') ? 'Not a valid email' : '';
  }
}

export interface DialogData {
  animal: string;
  name: string;
}
