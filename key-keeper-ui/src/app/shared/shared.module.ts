import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatToolbarModule } from '@angular/material/toolbar';
import { SidenavModule } from './modules/sidenav.module';

@NgModule({
  declarations: [],
  imports: [CommonModule, SidenavModule],
  exports: [SidenavModule],
})
export class SharedModule {}
