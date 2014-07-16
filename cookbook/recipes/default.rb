#
# Cookbook Name:: cb-nginx
# Recipe:: default
#

# Configure common
include_recipe 'cb-common'

# Configure tomcat
include_recipe 'cb-tomcat'

# Configure nginx
include_recipe 'cb-nginx'
