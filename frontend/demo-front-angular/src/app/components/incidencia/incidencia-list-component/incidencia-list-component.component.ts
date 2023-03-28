import { Component, OnInit } from '@angular/core';
import { Incidencia } from 'src/app/models/Incidencia';
import { IncidenciaService } from 'src/app/services/incidencia.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-incidencia-list-component',
  templateUrl: './incidencia-list-component.component.html',
  styleUrls: ['./incidencia-list-component.component.css']
})
export class IncidenciaListComponentComponent implements OnInit {

  lista:Incidencia[] = [];

  constructor(private incidenciaService:IncidenciaService) { }

  ngOnInit(): void {
    this.getAllIncidencias();
  }

  public getAllIncidencias(){
    this.incidenciaService.getAllIncidencias()
      .subscribe(i => {
        console.log("RESPONSE => " + i);
        this.lista = i;
      });
  }

  eliminar(incidencia:Incidencia):void{
    Swal.fire({
      title: "Cuidado:",
      text: `¿Seguro que desea eliminar a ${incidencia.id}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!'
    }).then((result) => {
      if(result.isConfirmed){
        this.incidenciaService.deleteIncidencia(incidencia.id)
          .subscribe(() => {
            this.getAllIncidencias();
            Swal.fire("Eliminado:", `Incidencia ${incidencia.id} eliminada con éxito`, 'success');
          })
      }
    })
  }
}
