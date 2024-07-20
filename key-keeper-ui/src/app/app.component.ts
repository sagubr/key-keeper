import { Component } from '@angular/core';
import { MENU_OPTIONS } from './configurations/options';
import { MenuOptions } from './configurations/options.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  menuOptions: MenuOptions[] = MENU_OPTIONS;
}
