package com.wordpress.smdaudhilbe.whatisrxjava;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends ActionBarActivity {

    private Observable<String> myObservable;
    private Subscriber<String> mySubscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {

        //  1.  detailed verbosed write up
//        myObservable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("Jack and jill went up the hill!!!");
//                subscriber.onCompleted();
//            }
//        });
//
//        mySubscriber = new Subscriber<String>() {
//
//            @Override
//            public void onCompleted() {
//                System.out.println("Yes completed!!!");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                System.out.println(s);
//            }
//        };
//
//        myObservable.subscribe(mySubscriber);

        //  2.  short hand write up
//        myObservable = Observable.just("Jack and jill went up the hill!!!");
//        Action1<String> onNextAction = new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println(s);
//            }
//        };
//        myObservable.subscribe(onNextAction);

        //  3.  get rid of those variables by just chaining the method calls
//        Observable.just("checking checking!!!").subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println(s);
//            }
//        });

        //  4. Java 8 lambdas
//        Observable.just("Hello, world!").subscribe(s -> System.out.println(s));

        //  5. map Operator
//        Observable.just("Jack and jill").map(new Func1<String, String>() {
//            @Override
//            public String call(String s) {
//                return s + " Audhil";
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println(s);
//            }
//        });

        //  6.  more on map()
//        Observable.just("Jack and jill went up the hill to fetch a pail of water!"
//        ).map(new Func1<String, Integer>() {
//            @Override
//            public Integer call(String s) {
//                return s.hashCode();
//            }
//        }).map(new Func1<Integer, String>() {
//            @Override
//            public String call(Integer integer) {
//                return integer.toString();
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println("s is : " + s);
//            }
//        });

//        exploring more methods - part 1
//        query("get");

//        exploring more methods - part 2
        exploreMore();
    }


    private void exploreMore() {
        Observable.from(myList).flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return getObservable(s);
            }
        }).take(1).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("s is : " + s);
            }
        });
    }

    private Observable<String> getObservable(String s) {
        return Observable.just(s).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return !s.equals("elephant");
            }
        });
    }


    String[] arrayOfString = new String[]{"apple", "ball", "cat", "dog"};
    List<String> myList = Arrays.asList("elephant", "fox", "gun", "hat");

    //  Query method
    public Observable<List<String>> query(String queryText) {

//        using array
//        Observable.just(arrayOfString).subscribe(new Action1<String[]>() {
//            @Override
//            public void call(String[] stringArray) {
//                for (String stringIs : stringArray) {
//                    System.out.println("jack and jill : " + stringIs);
//                }
//            }
//        });

//        using list
//        for (int i = 0; i < 4; i++) {
//            myList.add("value is : " + i);
//        }
//        Observable.just(myList).subscribe(new Action1<List<String>>() {
//            @Override
//            public void call(List<String> strings) {
//                for (String item : strings) {
//                    System.out.println("jack and jill : " + item);
//                }
//            }
//        });

        //        using new Operator FROM
//        to avoid for loop am going with Observable but still it is messy
//        Observable.just(myList).subscribe(new Action1<List<String>>() {
//            @Override
//            public void call(List<String> strings) {
//                Observable.from(strings).subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        System.out.println("inside Nested : " + s);
//                    }
//                });
//            }
//        });

//        my exploration examples
//        Observable.from(arrayOfString).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println("jack and jill : " + s);
//            }
//        });

//        using List
//        Observable.from(myList).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println("jack and jill : " + s);
//            }
//        });

        //        using new Operator FLATMAP
//        using list
//        Observable.just(myList).flatMap(new Func1<List<String>, Observable<String>>() {
//
//            @Override
//            public Observable<String> call(List<String> strings) {
//                return Observable.from(strings);
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println("jack and jill : " + s);
//            }
//        });

//        using array
//        Observable.just(arrayOfString).flatMap(new Func1<String[], Observable<String>>() {
//
//            @Override
//            public Observable<String> call(String[] strings) {
//                return Observable.from(strings);
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println("aha : " + s);
//            }
//        });

        //  to return only first char of the String
//        final ArrayList<String> listOfChars = new ArrayList<String>();
        Observable.just(myList).flatMap(new Func1<List<String>, Observable<String>>() {

            @Override
            public Observable<String> call(List<String> strings) {
                return Observable.from(strings);
            }
        }).flatMap(new Func1<String, Observable<String>>() {

            @Override
            public Observable<String> call(String s) {
//                return Observable.just(s).map(new Func1<String, String>() {
//                    @Override
//                    public String call(String s) {
//                        listOfChars.add(s.substring(0, 1));
//                        return s;
//                    }
//                });
                return getTitleOfString(s);
            }
        }).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s != null;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("aha : " + s);
            }
        });
        System.out.println("listOfChars : " + listOfChars);

        return null;
    }

    final ArrayList<String> listOfChars = new ArrayList<String>();

    private Observable<String> getTitleOfString(String s) {
        return Observable.just(s).map(new Func1<String, String>() {

            @Override
            public String call(String s) {

                if (!s.substring(0, 1).equals("e")) {
                    listOfChars.add(s.substring(0, 1));
                } else {
                    return null;
                }
                return s;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}