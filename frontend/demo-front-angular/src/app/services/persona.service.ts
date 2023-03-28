import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { BASE_ENDPOINT } from '../config/app';
import { Persona } from '../models/Persona';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  baseEndpoint: string = BASE_ENDPOINT + "/persona";
  cabeceras: HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});

  constructor(private http:HttpClient) { }

  public getAllPersonas(): Observable<Persona[]>{
    return this.http.get<Persona[]>(this.baseEndpoint);
  }
  
  public getByStatus(status:boolean): Observable<Persona[]>{
    return this.http.get<Persona[]>(`${this.baseEndpoint}/active`);
  }

  public getById(id:number):Observable<Persona>{
    return this.http.get<Persona>(`${this.baseEndpoint}/${id}`);
  }

  public crearPersona(persona:Persona): Observable<Persona>{
    persona.status = true;
    return this.http.post<Persona>(`${this.baseEndpoint}`,persona,
    {headers: this.cabeceras});
  }

  public updatePersona(persona:Persona, id:number): Observable<Persona>{
    console.log(`${this.baseEndpoint}/${id}`);
    return this.http.put<Persona>(`${this.baseEndpoint}/${id}`, persona, {headers: this.cabeceras});
  }

  public deletePersona(id:number): Observable<Persona>{
      return  this.http.delete<Persona>(`${this.baseEndpoint}/${id}`);
  }
}
