package com.twitter.finagle.loadbalancer

import com.twitter.finagle.stats.StatsReceiver
import java.net.SocketAddress
import com.twitter.finagle.{Group, NoBrokersAvailableException, ServiceFactory}

abstract class LoadBalancerFactory {
  def apply[Req, Rep](
    group: Group[(SocketAddress, ServiceFactory[Req, Rep])],
    globalStatsReceiver: StatsReceiver,
    statsReceiver: StatsReceiver,
    emptyException: NoBrokersAvailableException): ServiceFactory[Req, Rep]
}
