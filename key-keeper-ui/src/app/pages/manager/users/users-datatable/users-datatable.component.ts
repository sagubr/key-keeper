import {
  AfterViewInit,
  Component,
  OnDestroy,
  OnInit,
  ViewChild,
} from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { UserFilterService } from '../users-filters/user-filters.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-users-datatable',
  templateUrl: './users-datatable.component.html',
  styleUrls: ['./users-datatable.component.scss'],
})
export class UsersDatatableComponent
  implements AfterViewInit, OnInit, OnDestroy
{
  dataSource = new MatTableDataSource<User>(ELEMENT_DATA);
  displayedColumns: string[] = [
    'name',
    'username',
    'email',
    'active',
    'created_at',
    'star',
  ];
  pageSizeOptions = [5, 10, 20, 50, 100];

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  private _subscription?: Subscription;

  constructor(private readonly _filterService: UserFilterService) {}

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit() {
    this._subscription = this._filterService.filter$.subscribe((filter) => {
      this.applyFilter(filter);
    });
  }

  ngOnDestroy() {
    this._subscription?.unsubscribe();
  }

  applyFilter(event: String) {
    this.dataSource.filter = event.trim().toLowerCase();
  }
}

export interface User {
  name: String;
  username: String;
  email: String;
  active: boolean;
  created_at: String;
}

const ELEMENT_DATA: User[] = [
  {
    name: 'João Silva',
    username: 'joaosilva',
    email: 'joao.silva@example.com',
    active: true,
    created_at: '2023-07-27T10:00:00Z',
  },
  {
    name: 'Maria Oliveira',
    username: 'mariaoliveira',
    email: 'maria.oliveira@example.com',
    active: false,
    created_at: '2023-07-27T11:30:00Z',
  },
  {
    name: 'Carlos Pereira',
    username: 'carlospereira',
    email: 'carlos.pereira@example.com',
    active: true,
    created_at: '2023-07-27T12:45:00Z',
  },
  {
    name: 'Ana Costa',
    username: 'anacosta',
    email: 'ana.costa@example.com',
    active: true,
    created_at: '2023-07-27T13:20:00Z',
  },
  {
    name: 'Pedro Martins',
    username: 'pedromartins',
    email: 'pedro.martins@example.com',
    active: false,
    created_at: '2023-07-27T14:15:00Z',
  },
  {
    name: 'Paula Souza',
    username: 'paulasouza',
    email: 'paula.souza@example.com',
    active: true,
    created_at: '2023-07-27T15:00:00Z',
  },
  {
    name: 'Ricardo Lima',
    username: 'ricardolima',
    email: 'ricardo.lima@example.com',
    active: false,
    created_at: '2023-07-27T15:45:00Z',
  },
  {
    name: 'Juliana Alves',
    username: 'julianaalves',
    email: 'juliana.alves@example.com',
    active: true,
    created_at: '2023-07-27T16:30:00Z',
  },
  {
    name: 'Rafael Rocha',
    username: 'rafaelrocha',
    email: 'rafael.rocha@example.com',
    active: false,
    created_at: '2023-07-27T17:15:00Z',
  },
  {
    name: 'Fernanda Lima',
    username: 'fernandalima',
    email: 'fernanda.lima@example.com',
    active: true,
    created_at: '2023-07-27T18:00:00Z',
  },
  {
    name: 'Gustavo Ribeiro',
    username: 'gustavoribeiro',
    email: 'gustavo.ribeiro@example.com',
    active: true,
    created_at: '2023-07-27T18:45:00Z',
  },
  {
    name: 'Larissa Fernandes',
    username: 'larissafernandes',
    email: 'larissa.fernandes@example.com',
    active: false,
    created_at: '2023-07-27T19:30:00Z',
  },
  {
    name: 'Vinícius Melo',
    username: 'viniciusmelo',
    email: 'vinicius.melo@example.com',
    active: true,
    created_at: '2023-07-27T20:15:00Z',
  },
  {
    name: 'Beatriz Araújo',
    username: 'beatrizaraujo',
    email: 'beatriz.araujo@example.com',
    active: false,
    created_at: '2023-07-27T21:00:00Z',
  },
  {
    name: 'Gabriel Santos',
    username: 'gabrielsantos',
    email: 'gabriel.santos@example.com',
    active: true,
    created_at: '2023-07-27T21:45:00Z',
  },
  {
    name: 'Sofia Almeida',
    username: 'sofiaalmeida',
    email: 'sofia.almeida@example.com',
    active: true,
    created_at: '2023-07-27T22:30:00Z',
  },
  {
    name: 'Bruno Gomes',
    username: 'brunogomes',
    email: 'bruno.gomes@example.com',
    active: false,
    created_at: '2023-07-27T23:15:00Z',
  },
  {
    name: 'Amanda Freitas',
    username: 'amandafreitas',
    email: 'amanda.freitas@example.com',
    active: true,
    created_at: '2023-07-27T23:45:00Z',
  },
  {
    name: 'Felipe Barbosa',
    username: 'felipebarbosa',
    email: 'felipe.barbosa@example.com',
    active: false,
    created_at: '2023-07-28T00:15:00Z',
  },
  {
    name: 'Daniela Cardoso',
    username: 'danielacardoso',
    email: 'daniela.cardoso@example.com',
    active: true,
    created_at: '2023-07-28T00:45:00Z',
  },
];
