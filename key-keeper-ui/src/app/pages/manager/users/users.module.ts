import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsersComponent } from './users.component';
import { RouterModule, Routes } from '@angular/router';
import { UsersDatatableModule } from './users-datatable/users-datatable.module';
import { UsersFiltersModule } from './users-filters/users-filters.module';

const routes: Routes = [{ path: '', component: UsersComponent }];

@NgModule({
  declarations: [UsersComponent],
  imports: [
    CommonModule,
    UsersFiltersModule,
    UsersDatatableModule,

    RouterModule.forChild(routes),
  ],
  exports: [UsersComponent],
})
export class UsersModule {}
