import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ToolbarHeaderComponent } from './toolbar-header.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@NgModule({
  declarations: [ToolbarHeaderComponent],
  imports: [CommonModule, MatToolbarModule, MatButtonModule, MatIconModule],
  exports: [ToolbarHeaderComponent],
})
export class ToolbarHeaderModule {}
