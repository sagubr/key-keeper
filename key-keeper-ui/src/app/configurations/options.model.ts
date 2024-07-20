export interface MenuOptions {
  title: string;
  icon: string;
  route: string;
  subMenu?: MenuOptions[];
  permission?: string[];
}
