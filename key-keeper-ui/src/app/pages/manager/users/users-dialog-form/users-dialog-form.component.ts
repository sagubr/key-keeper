import { Component, Inject } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-users-dialog-form',
  templateUrl: './users-dialog-form.component.html',
  styleUrls: ['./users-dialog-form.component.scss'],
})
export class UsersDialogFormComponent {

  emailFormControl = new FormControl('', [Validators.required, Validators.email]);

  hide = true;

  constructor(
    public dialogRef: MatDialogRef<UsersDialogFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}

export interface DialogData {
  animal: string;
  name: string;
}
