import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidenavModule } from './modules/sidenav.module';
import { ToolbarHeaderModule } from './components/toolbar-header/toolbar-header.module';

@NgModule({
  declarations: [],
  imports: [CommonModule, SidenavModule, ToolbarHeaderModule],
  exports: [SidenavModule, ToolbarHeaderModule],
})
export class SharedModule {}
