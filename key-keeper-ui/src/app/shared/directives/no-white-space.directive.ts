import { Directive, HostListener } from '@angular/core';
import { NgControl } from '@angular/forms';

@Directive({
  selector: '[appNoWhiteSpace]',
})
export class NoWhiteSpaceDirective {
  constructor(private ngControl: NgControl) {}

  @HostListener('input', ['$event'])
  onInputChange(event: any) { 
    console.log("5", event.key);
    const value = this.ngControl.control?.value;
    if (value) {
      this.ngControl.control?.setValue(value.replace(/\s/g, ''));
    }
  }

  @HostListener('keydown', ['$event'])
  onKeydown(event: KeyboardEvent) {
    console.log("5", event.key);
    if (event.key === ' ') {
      event.preventDefault();
    }
  }
}
