package Controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import View.Popup;

public class HorarioController {
	
	/*
	Timer timer1= null;
    try
    {
        timer1= new Timer(true);
        Calendar calendario = new GregorianCalendar();
        calendario.set(Calendar.DAY_OF_MONTH,calendario.get(Calendar.DAY_OF_MONTH) + 1);
        calendario.set(Calendar.HOUR_OF_DAY, TConstantes.HORA);
        calendario.set(Calendar.MINUTE, TConstantes.MINUTO);
        calendario.set(Calendar.SECOND, 0);
        timer1.scheduleAtFixedRate(new ProcessoExecutar(), calendario.getTime(), TConstantes.PERIODO);
    }
    catch (Exception e)
    {
        
    }
	
}*/
	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	public void iniciarExecucaoEm(int hora, int min, int seg)
    {
		Popup pop1=new Popup();
        Runnable taskWrapper = new Runnable(){

            @Override
            public void run() 
            {
                pop1.acao();
                iniciarExecucaoEm(hora, min, seg);
            }

        };
        long delay = computeNextDelay(hora, min, seg);
        scheduler.schedule(taskWrapper, delay, TimeUnit.SECONDS);//pode ser que nao seja scheduler
    }
	
	private long computeNextDelay(int hora, int min, int seg) 
	//transforma a diferenca da data atual e a marcada em uma long
    {
        LocalDateTime localNow = LocalDateTime.now();
        ZoneId currentZone = ZoneId.systemDefault();
        ZonedDateTime zonedNow = ZonedDateTime.of(localNow, currentZone);
        ZonedDateTime zonedNextTarget = zonedNow.withHour(hora).withMinute(min).withSecond(seg);
        if(zonedNow.compareTo(zonedNextTarget) > 0)
            zonedNextTarget = zonedNextTarget.plusDays(1);

        Duration duration = Duration.between(zonedNow, zonedNextTarget);
        return duration.getSeconds();
    }
}
