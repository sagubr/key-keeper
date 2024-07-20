import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsersComponent } from './users.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { RouterModule, Routes } from '@angular/router';
import { MatTabsModule } from '@angular/material/tabs';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';

const routes: Routes = [{ path: '', component: UsersComponent }];

@NgModule({
  declarations: [UsersComponent],
  imports: [
    CommonModule,
    SharedModule,
    MatTabsModule,
    MatTableModule,
    MatPaginatorModule,

    RouterModule.forChild(routes),
  ],
  exports: [UsersComponent],
})
export class UsersModule {}
