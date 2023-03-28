import { Persona } from "./Persona";

export class UnidadNegocio {
    id: number;
    nombre: string;
    unidadPadre: UnidadNegocio = null;
    //hijas: UnidadNegocio[] = [];
    gerente: Persona = null;
    status: boolean;

    constructor(){
        
    }
    
}