import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RouterModule, Routes } from '@angular/router';
import { ManagerComponent } from './manager.component';
import { UsersModule } from './users/users.module';
import { ToolbarHeaderModule } from '../../shared/components/toolbar-header/toolbar-header.module';
import { MatTabsModule } from '@angular/material/tabs';
import { MatIconModule } from '@angular/material/icon';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { RoomsComponent } from './rooms/rooms.component';

const routes: Routes = [{ path: '', component: ManagerComponent }];

@NgModule({
  declarations: [ManagerComponent, RoomsComponent],
  imports: [
    CommonModule,
    UsersModule,
    ToolbarHeaderModule,
    MatTabsModule,
    MatIconModule,
    MatProgressBarModule,
    RouterModule.forChild(routes),
  ],
  exports: [ManagerComponent],
})
export class ManagerModule {}
