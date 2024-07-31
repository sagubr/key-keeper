import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidenavModule } from './modules/sidenav.module';
import { ToolbarHeaderModule } from './components/toolbar-header/toolbar-header.module';
import { NoWhiteSpaceDirective } from './directives/no-white-space.directive';

@NgModule({
  declarations: [NoWhiteSpaceDirective],
  imports: [CommonModule, SidenavModule, ToolbarHeaderModule],
  exports: [SidenavModule, ToolbarHeaderModule],
})
export class SharedModule {}
