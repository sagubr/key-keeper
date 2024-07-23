import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsersComponent } from './users.component';
import { UsersDatatableModule } from './users-datatable/users-datatable.module';
import { UsersFiltersModule } from './users-filters/users-filters.module';

@NgModule({
  declarations: [UsersComponent],
  imports: [
    CommonModule,
    UsersFiltersModule,
    UsersDatatableModule
  ],
  exports: [UsersComponent],
})
export class UsersModule {}
