import { Component, Inject } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { DialogData } from '../users-dialog-form/users-dialog-form.component';

@Component({
  selector: 'app-users-dialog-password-form',
  templateUrl: './users-dialog-password-form.component.html',
  styleUrls: ['./users-dialog-password-form.component.scss']
})
export class UsersDialogPasswordFormComponent {
  form = new FormGroup({
    password: new FormControl('', [Validators.required]),
    repeatPassword: new FormControl('', [Validators.required]),
  });

  hide = true;

  constructor(
    public dialogRef: MatDialogRef<UsersDialogPasswordFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  getErrorMessage() {
    if (this.form.get('email')?.hasError('required')) {
      return 'Você deve inserir um valor';
    }
    return this.form.get('email')?.hasError('email')
      ? 'Não é um e-mail válido'
      : '';
  }

  checkPasswords() {
    const password = this.form.get('password')?.value;
    const repeatPassword = this.form.get('repeatPassword')?.value;
    console.log(!(password === repeatPassword));
    return !(password === repeatPassword);
  }
}
