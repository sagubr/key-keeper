import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsersDatatableComponent } from './users-datatable.component';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressBarModule } from '@angular/material/progress-bar';

@NgModule({
  declarations: [UsersDatatableComponent],
  imports: [
    CommonModule,
    MatTableModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatButtonModule,
  ],
  exports: [UsersDatatableComponent],
})
export class UsersDatatableModule {}
