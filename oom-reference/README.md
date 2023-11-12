# oom-reference
* OOM 을 발생시키고, 힙덤프 분석
  * -XX:+HeapDumpOnOutOfMemoryError
  * -XX:HeapDumpPath=${힙덤프 생성할 경로}

## gradle 에서 JVM 옵션 주기
```gradle.kts
plugins {
    application
}
// 생략 ...
application {
    // https://docs.gradle.org/current/userguide/application_plugin.html
    // gradle task : bootRun
    applicationDefaultJvmArgs = listOf(
        "-Xms400m",
        "-Xmx400m",
        "-Xlog:gc::time",
        "-Xlog:gc*:file=${project.rootDir}/mygc.log,filecount=5,filesize=50m:time",
        "-XX:+HeapDumpOnOutOfMemoryError",
        "-XX:HeapDumpPath=${project.rootDir}"
    )
}
```

## StrongReference vs SoftReference vs WeakReference 비교
* [visualVM 으로 지표 비교](./README-visualvm.md)

## gc 관련 옵션
* `java9이상`
  * -Xlog:gc*
  * -Xlog:gc*::time (디테일한 시간까지 본다.)
  * -Xlog:gc*:file=gc.log,filecount=5,filesize=50m (GC 로그 로테이션 및 파일 설정)
* `java9미만`
  * -verbose:gc (가비지 컬렉터 정보 콘솔 출력) 
  * -XX:+UseGCLogFileRotation (GC 로그 로테이션 여부)
  * -XX:GCLogFileSize=50m (GC 로그 사이즈)
  * -XX:NumberOfGCLogFiles=5 (GC 로그 갯수)
  * -Xloggc:/log/gc.log (GC 로그 경로 및 파일 지정)
  * -XX:+PrintGCDetails (디테일하게 노출)
  * -XX:+PrintGCTimeStamps (GC 발생 시간 : 애플리케이션 띄어지고 나서 경과된 시간)
  * -XX:+PrintGCDateStamps (GC 발생 시간 : 현재 설정된 타임존 시간 기준)
* gc 파일 분석하기
  * https://gceasy.io/ 를 이용하여 아래 내용들을 파악 가능
    * GC 이전/이후 힙 메모리 지표
    * GC 수행속도
    * 오브젝트 크기 등

## JDK8 에서 Metaspace 영역 추가
* JDK8 에서 Heap 사이즈의 일부를 차지하던 Permanent Generation 은 Metaspace 로 대체되었음 (링크 참고)
  * Metaspace 는 클래스의 메타데이터를 저장하는 동적 메모리 공간. 
  * 이로인해서 "java.lang.OutOfMemoryError: PermGen space" 에러는 더이상 JDK8 이상부터는 확인할 수 없음
* 따라서 Java8 에서의 JVM 메모리는 Java Heap, Metaspace(Native Memory) 영역 둘의 영역이라고 본다.
* JVM 옵션으로 사이즈를 지정해서 줄 수 있다.
  * -XX:MetaspaceSize=512M
  * -XX:MaxMetaspaceSize=512M

## Native Memory Tracking
Native Memory 영역을 트랙킹 하기 위한 명령어 및 방법
* -XX:NativeMemoryTracking=summary 또는 -XX:NativeMemoryTracking=detail 옵션을 준다. (링크 참고)
  * `$ jcmd ${pid} VM.native_memory baseline` 명령어를 수행


시리즈I am Developer!
[Java Memory Profiling에 대하여] ① JVM 메모리 이해와 케이스 스터디
## reference
* [gradle application plugins](https://docs.gradle.org/current/userguide/application_plugin.html)
* [JDK 8에서 Perm 영역은 왜 삭제됐을까](https://johngrib.github.io/wiki/java8-why-permgen-removed/)
* [Java Memory Profiling에 대하여 : ① JVM 메모리 이해와 케이스 스터디](https://m.post.naver.com/viewer/postView.nhn?volumeNo=23726161&memberNo=36733075)
* [Java Memory Profiling에 대하여 : ② 메모리 모니터링과 원인분석](https://m.post.naver.com/viewer/postView.naver?volumeNo=24042502&memberNo=36733075&navigationType=push)
* [Native Memory Tracking-1](https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/tooldescr007.html#BABGFCDA)
* [Native Memory Tracking-2](https://docs.oracle.com/javase/8/docs/technotes/guides/vm/nmt-8.html)

