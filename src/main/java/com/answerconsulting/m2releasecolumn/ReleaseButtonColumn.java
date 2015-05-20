package com.answerconsulting.m2releasecolumn;

import java.security.PermissionCollection;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.Job;
import hudson.views.ListViewColumnDescriptor;
import hudson.views.ListViewColumn;
import hudson.security.Permission;

import org.kohsuke.stapler.DataBoundConstructor;

public class ReleaseButtonColumn extends ListViewColumn {

    public static final Permission RELEASE_PERMISSION = Permission.fromId("hudson.model.Item.Release");

    @DataBoundConstructor
    public ReleaseButtonColumn() {
    }

    public static boolean hasReleasePermission(@SuppressWarnings("rawtypes") AbstractProject job) {
        return job.hasPermission(RELEASE_PERMISSION);
    }

    @Extension
    public static class DescriptorImpl extends ListViewColumnDescriptor {

        @Override
        public boolean shownByDefault() {
            return false;
        }

        @Override
        public String getDisplayName() {
            return Messages.ReleaseButtonColumn_DisplayName();
        }
        
    }
}