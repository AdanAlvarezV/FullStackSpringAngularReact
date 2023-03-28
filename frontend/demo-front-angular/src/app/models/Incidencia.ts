import { Persona } from "./Persona";

export class Incidencia {
    id: number;
    date: string;
    reporta: Persona = null;
    reportado: Persona = null;
    descripcion: string;
    status:string;

}