import { Component, OnInit } from '@angular/core';
import { UnidadNegocio } from 'src/app/models/UnidadNegocio';
import { UnidadnegocioService } from 'src/app/services/unidadnegocio.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-unidad-negocio-list-component',
  templateUrl: './unidad-negocio-list-component.component.html',
  styleUrls: ['./unidad-negocio-list-component.component.css']
})
export class UnidadNegocioListComponentComponent implements OnInit {

  lista:UnidadNegocio[] = [];

  constructor(private unidadService:UnidadnegocioService) { }

  ngOnInit(): void {
    this.getAllUnidades();
  }

  public getAllUnidades(){
    this.unidadService.getByStatus(true)
      .subscribe(u => {
        console.log("RESPONSE => " + u);
        this.lista = u;
      });
  }

  eliminar(unidad:UnidadNegocio):void{
    Swal.fire({
      title: "Cuidado:",
      text: `¿Seguro que desea eliminar a ${unidad.nombre}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!'
    }).then((result) => {
      if(result.isConfirmed){
        this.unidadService.deleteUnidadNegocio(unidad.id)
          .subscribe(() => {
            this.getAllUnidades();
            Swal.fire("Eliminado:", `Unidad de negocio ${unidad.nombre} eliminada con éxito`, 'success');
          })
      }
    })
  }

}
