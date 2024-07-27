import { Component, EventEmitter, Output } from '@angular/core';
import { UsersDialogFormComponent } from '../users-dialog-form/users-dialog-form.component';
import { MatDialog } from '@angular/material/dialog';
import { Subject } from 'rxjs';
import { UserFilterService } from './user-filters.service';

export interface Food {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-users-filters',
  templateUrl: './users-filters.component.html',
  styleUrls: ['./users-filters.component.scss'],
})
export class UsersFiltersComponent {
  foods: Food[] = [
    { value: 'steak-0', viewValue: 'Steak' },
    { value: 'pizza-1', viewValue: 'Pizza' },
    { value: 'tacos-2', viewValue: 'Tacos' },
  ];

  animal: string = '';
  name: string = '';

  constructor(public dialog: MatDialog,
    private filterService: UserFilterService
  ) {}

  openDialog(): void {
    const dialogRef = this.dialog.open(UsersDialogFormComponent, {
      data: { name: this.name, animal: this.animal },
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log('The dialog was closed');
      this.animal = result;
    });
  }

  onSearch(event: Event) {
    const value = (event.target as HTMLInputElement).value;
    console.log(`filter by: ${value}`);
    this.filterService.setFilter(value);
  }
}
