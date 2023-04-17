package com.todoist.tests.mobile.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;


public class DeviceHelper {

    public static String executeSh(String command) throws IOException, ExecutionException, InterruptedException {
        Process p = Runtime.getRuntime().exec(command);
        FutureTask<String> future = new FutureTask<>(() -> {
            return new BufferedReader(new InputStreamReader(p.getInputStream()))
                    .lines().map(Object::toString)
                    .collect(Collectors.joining("\n"));
        });
        new Thread(future).start();
        return future.get();
    }
}
