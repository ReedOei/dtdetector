package edu.illinois.diaper.agent;
import java.lang.instrument.*;

public class MainAgent {  
    private static Instrumentation inst;
   
    public static Instrumentation getInstrumentation() { return inst; }
   
    public static void premain(String agentArgs, Instrumentation inst) {
        MainAgent.inst = inst;
    }  
}  
