/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import javax.sound.sampled.Clip;

/**
 *
 * @author angel
 */
public class Sound {
    final private Clip sonido;

	public Sound(final String ruta) {
		sonido = CargadorDeRecursos.cargarSonido(ruta);
	}
	
	public void reproducir() {
		sonido.stop();
		sonido.flush();
		sonido.setMicrosecondPosition(0);
		sonido.start();
	}
	
	public void repetir() {
		sonido.stop();
		sonido.flush();
		sonido.setMicrosecondPosition(0);
		
		sonido.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public long obtenerDuracion() {
		return sonido.getMicrosecondLength();
	}
        public void stop(){
                sonido.stop();
        }
}
