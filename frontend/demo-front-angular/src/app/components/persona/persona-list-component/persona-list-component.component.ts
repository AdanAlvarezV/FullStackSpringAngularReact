import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/models/Persona';
import { PersonaService } from 'src/app/services/persona.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-persona-list-component',
  templateUrl: './persona-list-component.component.html',
  styleUrls: ['./persona-list-component.component.css']
})
export class PersonaListComponentComponent implements OnInit {

  lista:Persona[] = [];

  constructor(private personaService:PersonaService) { }

  ngOnInit(): void {
    this.getAllPersonas();
  }

  public getAllPersonas(){
    this.personaService.getByStatus(true)
      .subscribe(p => {
        console.log("RESPONSE => " + p);
        this.lista = p;
      });
  }

  eliminar(persona:Persona):void{
    Swal.fire({
      title: "Cuidado:",
      text: `¿Seguro que desea eliminar a ${persona.nombre}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!'
    }).then((result) => {
      if(result.isConfirmed){
        this.personaService.deletePersona(persona.id)
          .subscribe(() => {
            this.getAllPersonas();
            Swal.fire("Eliminado:", `Persona ${persona.nombre} eliminada con éxito`, 'success');
          })
      }
    })
  }
}
